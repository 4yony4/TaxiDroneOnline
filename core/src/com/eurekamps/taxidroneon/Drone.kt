package com.eurekamps.taxidroneon

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.physics.box2d.*

class Drone {

    val DRONE_IMG_PATH="eurekamps.png"
    val SIZE_DRONE=3
    val X_START=10f
    val Y_START=10f

    var body:Body?=null
    var world:World

    var img: Texture? = null

    constructor(world:World){
        this.world=world
        img = Texture(DRONE_IMG_PATH)
        createBody(world,X_START,Y_START)
    }

    fun createBody(world:World,x:Float,y:Float){
        var bodyDef=BodyDef()
        bodyDef.fixedRotation=true
        bodyDef.type=BodyDef.BodyType.DynamicBody
        bodyDef.position[x]=y

        val shape=PolygonShape()
        shape.setAsBox((SIZE_DRONE/TaxiUniverse.PIXEL_PER_METER)/2,(SIZE_DRONE/TaxiUniverse.PIXEL_PER_METER)/2)

        var fixtureDef=FixtureDef()
        fixtureDef.shape=shape
        fixtureDef.density=1.0f

        body=world.createBody(bodyDef)
        var fixtureRes=body!!.createFixture(fixtureDef)
        fixtureRes.userData=this
    }

    fun draw(batch:SpriteBatch){
        batch.draw(img,body!!.position.x*TaxiUniverse.PIXEL_PER_METER-(SIZE_DRONE/2),
                body!!.position.y*TaxiUniverse.PIXEL_PER_METER-(SIZE_DRONE/2),
                SIZE_DRONE*TaxiUniverse.PIXEL_PER_METER,SIZE_DRONE*TaxiUniverse.PIXEL_PER_METER)
        //batch.draw(img,100f,500f)
    }

}