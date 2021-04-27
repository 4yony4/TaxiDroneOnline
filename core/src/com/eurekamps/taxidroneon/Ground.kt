package com.eurekamps.taxidroneon

import com.badlogic.gdx.physics.box2d.Body
import com.badlogic.gdx.physics.box2d.BodyDef
import com.badlogic.gdx.physics.box2d.Shape
import com.badlogic.gdx.physics.box2d.World

class Ground {
    private val DENSITY=1.0f

    constructor(world: World?,shape:Shape?){
        val body:Body
        val bodyDef = BodyDef()
        bodyDef.type = BodyDef.BodyType.StaticBody
        body = world!!.createBody(bodyDef)
        val fixture=body.createFixture(shape,DENSITY)
        fixture.userData=this
        shape!!.dispose()

    }

}