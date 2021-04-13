package com.eurekamps.taxidroneon

import com.badlogic.gdx.physics.box2d.Body
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

}