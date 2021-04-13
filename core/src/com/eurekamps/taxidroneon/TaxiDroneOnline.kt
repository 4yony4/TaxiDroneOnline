package com.eurekamps.taxidroneon

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch

class TaxiDroneOnline: ApplicationAdapter() {
    //var batch: SpriteBatch? = null
    //var img: Texture? = null
    lateinit var taxiUniverse:TaxiUniverse

    override fun create() {
        taxiUniverse= TaxiUniverse()
        //batch = SpriteBatch()
        //img = Texture("badlogic.jpg")
    }

    override fun render() {
        taxiUniverse.draw()
        /*batch!!.begin()
        batch!!.draw(img, 0f, 0f)
        batch!!.end()*/
    }

    override fun dispose() {
        taxiUniverse.destroy()
        //batch!!.dispose()
        //img!!.dispose()
    }
}