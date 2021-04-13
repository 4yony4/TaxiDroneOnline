package com.eurekamps.taxidroneon

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.physics.box2d.World

class TaxiUniverse {

    companion object{
        val PIXEL_PER_METER=32f
    }

    var world:World
    var orthographicCamera:OrthographicCamera


    constructor() {

        world = World(Vector2(0f, -9.8f), false)
        orthographicCamera = OrthographicCamera()

    }

    fun draw(){
        Gdx.gl.glClearColor(0f, 0f, 1f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
    }

    fun destroy(){
        world.dispose()


    }


}