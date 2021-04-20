package com.eurekamps.taxidroneon

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.physics.box2d.Contact
import com.badlogic.gdx.physics.box2d.ContactImpulse
import com.badlogic.gdx.physics.box2d.ContactListener
import com.badlogic.gdx.physics.box2d.Manifold

class TaxiUniverseCollisionsListener:ContactListener {
    override fun beginContact(contact: Contact?) {
        val f1=contact!!.fixtureA
        val f2=contact!!.fixtureB
        if(f1.userData is Drone){

        }
        //Gdx.app.log("MyTag", "beginContact")
    }

    override fun endContact(contact: Contact?) {
        //Gdx.app.log("MyTag", "endContact")
    }

    override fun preSolve(contact: Contact?, oldManifold: Manifold?) {
        //Gdx.app.log("MyTag", "preSolve")
    }

    override fun postSolve(contact: Contact?, impulse: ContactImpulse?) {
        //Gdx.app.log("MyTag", "postSolve")
    }
}