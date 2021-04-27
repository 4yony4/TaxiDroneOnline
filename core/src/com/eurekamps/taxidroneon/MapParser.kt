package com.eurekamps.taxidroneon

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.maps.objects.PolygonMapObject
import com.badlogic.gdx.maps.objects.RectangleMapObject
import com.badlogic.gdx.maps.tiled.TiledMap
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.physics.box2d.ChainShape
import com.badlogic.gdx.physics.box2d.PolygonShape
import com.badlogic.gdx.physics.box2d.Shape
import com.badlogic.gdx.physics.box2d.World

class MapParser {


    fun parseLayers(world:World?,tiledMap:TiledMap){

        for (layer in tiledMap.layers){

            for (layerObject in layer.objects){
                var shape: Shape? =null
                if (layerObject is PolygonMapObject){
                    shape=createPolygonShape(layerObject)
                }
                else if(layerObject is RectangleMapObject){
                    shape=createRectangleShape(layerObject)
                }

                if(layer.name=="ground")Ground(world,shape)


            }

        }

    }

    fun createPolygonShape(polygon:PolygonMapObject):ChainShape{
        val vertices=polygon.polygon.transformedVertices
        val worldVertices=arrayOfNulls<Vector2>(vertices.size/2)
        for(i in worldVertices.indices){
            Gdx.app.log("MyTag", "VERTICE Y: "+vertices[(i*2)+1])
            worldVertices[i]=Vector2(vertices[i*2]/TaxiUniverse.PIXEL_PER_METER,(vertices[(i*2)+1])/(TaxiUniverse.PIXEL_PER_METER))
        }
        val chainShape=ChainShape()
        chainShape.createChain(worldVertices)
        return chainShape
    }

    fun createRectangleShape(rectangle:RectangleMapObject):Shape{

        val shape = PolygonShape()

        val ynueva=rectangle.rectangle.y-100
        val vectorSize=Vector2(((rectangle.rectangle.x+rectangle.rectangle.width)*0.5f)/TaxiUniverse.PIXEL_PER_METER,
                ((ynueva+rectangle.rectangle.height)*0.5f)/TaxiUniverse.PIXEL_PER_METER)
        shape.setAsBox(rectangle.rectangle.width*0.5f/TaxiUniverse.PIXEL_PER_METER,rectangle.rectangle.height*0.5f/TaxiUniverse.PIXEL_PER_METER,
                vectorSize,0.0f)
        return shape

    }


}