package com.eurekamps.taxidroneon

import com.badlogic.gdx.physics.box2d.Body
import com.badlogic.gdx.physics.box2d.BodyDef
import com.badlogic.gdx.physics.box2d.PolygonShape
import com.badlogic.gdx.physics.box2d.World

class Drone {

    val DRONE_IMG_PATH="eurekamps.png"
    val SIZE_DRONE=32
    val X_START=8f
    val Y_START=18f

    var body:Body?=null
    var world:World

    constructor(world:World){
        this.world=world
    }

    fun createBody(world:World,x:Float,y:Float){
        var bodyDef=BodyDef()
        bodyDef.fixedRotation=true
        bodyDef.type=BodyDef.BodyType.DynamicBody
        bodyDef.position[x]=y

        val shape=PolygonShape()
        shape.setAsBox((SIZE_DRONE/TaxiUniverse.PIXEL_PER_METER)/2,(SIZE_DRONE/TaxiUniverse.PIXEL_PER_METER)/2)

    }

}