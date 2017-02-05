package com.abc.adapter

import com.abc.model.VendorResponse
import com.google.gson.*
import java.lang.reflect.Type
import java.util.*

class VendorResponseAdapter : JsonSerializer<Array<VendorResponse>>, JsonDeserializer<Array<VendorResponse>> {

    override fun serialize(src: Array<VendorResponse>, typeOfSrc: Type, context: JsonSerializationContext): JsonElement {
        val res = JsonArray();
        for (resp in src) {
            val element = JsonObject()
            element.add("type", JsonPrimitive(resp.javaClass.simpleName))
            element.add("props", context.serialize(resp, resp.javaClass))
            res.add(element)
        }
        return res
    }

    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): Array<VendorResponse> {
        return json.asJsonArray.mapNotNullTo(ArrayList<VendorResponse>()) {
            try {
                val jsonObj = it.asJsonObject
                val type = jsonObj["type"].asString
                val element = jsonObj["props"]
                context.deserialize(element, Class.forName("com.abc.model.vendor.$type"))
            } catch (e: ClassNotFoundException) {
                null
            }
        }.toTypedArray()
    }

}