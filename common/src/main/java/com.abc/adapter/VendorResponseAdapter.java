package com.abc.adapter;

import com.abc.model.VendorResponse;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VendorResponseAdapter implements JsonSerializer<VendorResponse[]>, JsonDeserializer<VendorResponse[]> {

    @Override
    public VendorResponse[] deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        List<VendorResponse> res = new ArrayList<>();
        for (JsonElement arrayElement : json.getAsJsonArray()){
            try {
                JsonObject jsonObj = arrayElement.getAsJsonObject();
                String type = jsonObj.get("type").getAsString();
                JsonElement element = jsonObj.get("props");
                res.add(context.deserialize(element, Class.forName("com.abc.model.vendor."+type)));
            } catch (ClassNotFoundException e) {
                System.out.println("add logs");
            }
        }
        return res.toArray(new VendorResponse[res.size()]);
    }

    @Override
    public JsonElement serialize(VendorResponse[] src, Type typeOfSrc, JsonSerializationContext context) {
        JsonArray res = new JsonArray();
        for (VendorResponse resp : src) {
            JsonObject element = new JsonObject();
            element.add("type", new JsonPrimitive(resp.getClass().getSimpleName()));
            element.add("props", context.serialize(resp, resp.getClass()));
            res.add(element);
        }
        return res;
    }
}
