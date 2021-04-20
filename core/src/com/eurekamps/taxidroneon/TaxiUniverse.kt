package com.eurekamps.taxidroneon

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.maps.tiled.TiledMap
import com.badlogic.gdx.maps.tiled.TmxMapLoader
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.physics.box2d.*

class TaxiUniverse {
    var batch: SpriteBatch? = null

    companion object{
        private val SCALE = 1.0f
        val PIXEL_PER_METER=128f
        val MAP_PATH="maps/map2.tmx"
    }

    var world:World
    var orthographicCamera:OrthographicCamera
    var drone:Drone

    var bodyGround:Body?=null
    var box2DDebugRenderer:Box2DDebugRenderer?=null

    var tiledMap:TiledMap
    var tiledMapRenderer:OrthogonalTiledMapRenderer



    constructor() {
        batch = SpriteBatch()
        world = World(Vector2(0f, -9.8f), false)

        orthographicCamera = OrthographicCamera()
        orthographicCamera.setToOrtho(false, Gdx.graphics.width / SCALE, Gdx.graphics.height / SCALE);

        drone= Drone(world)
        box2DDebugRenderer= Box2DDebugRenderer()
        world.setContactListener(TaxiUniverseCollisionsListener())

        tiledMap=TmxMapLoader().load(MAP_PATH)
        tiledMapRenderer= OrthogonalTiledMapRenderer(tiledMap)

        createGround()

    }

    fun createGround(){
        val bodyDef = BodyDef()
        bodyDef.type = BodyDef.BodyType.StaticBody
        bodyDef.position.set(0f,5f)
        val fixtureDef = FixtureDef()
        fixtureDef.friction = 1f
        val shape = PolygonShape()
        shape.setAsBox(Gdx.graphics.width.toFloat(),40f/PIXEL_PER_METER)

        fixtureDef.shape = shape

        bodyGround = world!!.createBody(bodyDef)
        bodyGround!!.createFixture(fixtureDef)
        //bodyGround!!.setTransform(0f, 0f, 0f)
        //shape.dispose()
    }

    fun resize(width: Int, height: Int){
        orthographicCamera.setToOrtho(false, width / SCALE, height / SCALE);
    }


    fun update(){
        world.step(1/60f,6,2)
        cameraUpdate()
        tiledMapRenderer.setView(orthographicCamera)
        //batch?.setProjectionMatrix(orthographicCamera.combined)
    }

    private fun cameraUpdate(){
        val position=orthographicCamera.position
        position.x = drone.body!!.getPosition().x * PIXEL_PER_METER
        position.y = drone.body!!.getPosition().y * PIXEL_PER_METER
        orthographicCamera.position.set(position)
        orthographicCamera.update()
    }

    var shapeRenderer:ShapeRenderer= ShapeRenderer()
    fun draw(){
        update()
        Gdx.gl.glClearColor(0f, 0f, 1f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        tiledMapRenderer.render()

        batch?.begin()
        drone.draw(batch!!)
        batch?.end()

        /*shapeRenderer.begin(ShapeRenderer.ShapeType.Filled)
        shapeRenderer.rect(0f,0f,Gdx.graphics.width.toFloat(),20f)
        shapeRenderer.end();


        box2DDebugRenderer!!.render(world,orthographicCamera.combined.scl(PIXEL_PER_METER))*/
    }

    fun destroy(){
        world.dispose()


    }


}