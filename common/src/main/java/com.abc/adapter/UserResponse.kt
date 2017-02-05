package com.abc.adapter

import com.abc.model.rest.DecisionResponse
import com.google.gson.*
import java.lang.reflect.Type

class UserResponse : JsonSerializer<DecisionResponse>, JsonDeserializer<DecisionResponse> {

    override fun serialize(src: DecisionResponse, typeOfSrc: Type, context: JsonSerializationContext): JsonElement {
        val res = JsonObject();
        res.add("type", JsonPrimitive(src.javaClass.simpleName))
        res.add("props", context.serialize(src, src.javaClass))
        return res
    }

    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): DecisionResponse {
        val jsonObj = json.asJsonObject
        val type = jsonObj["type"].asString
        val element = jsonObj["props"]
        return context.deserialize(element, Class.forName("com.abc.model.rest.$type"))
    }

}