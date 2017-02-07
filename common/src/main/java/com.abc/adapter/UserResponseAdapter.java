package com.abc.adapter;

import com.abc.model.rest.DecisionResponse;
import com.google.gson.*;

import java.lang.reflect.Type;

public class UserResponseAdapter implements JsonSerializer<DecisionResponse>, JsonDeserializer<DecisionResponse> {

    @Override
    public DecisionResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObj = json.getAsJsonObject();
        String type = jsonObj.get("type").getAsString();
        JsonElement element = jsonObj.get("props");
        try {
            return context.deserialize(element, Class.forName("com.abc.model.rest." + type));
        } catch (ClassNotFoundException e) {
            System.out.println("Add logs");
        }
        return null;
    }

    @Override
    public JsonElement serialize(DecisionResponse src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject res = new JsonObject();
        res.add("type", new JsonPrimitive(src.getClass().getSimpleName()));
        res.add("props", context.serialize(src, src.getClass()));
        return res;
    }

}
