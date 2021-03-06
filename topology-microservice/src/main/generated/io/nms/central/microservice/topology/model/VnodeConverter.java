package io.nms.central.microservice.topology.model;

import io.vertx.core.json.JsonObject;
import io.vertx.core.json.JsonArray;
import java.time.Instant;
import java.time.format.DateTimeFormatter;

/**
 * Converter for {@link io.nms.central.microservice.topology.model.Vnode}.
 * NOTE: This class has been automatically generated from the {@link io.nms.central.microservice.topology.model.Vnode} original class using Vert.x codegen.
 */
public class VnodeConverter {

  public static void fromJson(Iterable<java.util.Map.Entry<String, Object>> json, Vnode obj) {
    for (java.util.Map.Entry<String, Object> member : json) {
      switch (member.getKey()) {
        case "created":
          if (member.getValue() instanceof String) {
            obj.setCreated((String)member.getValue());
          }
          break;
        case "description":
          if (member.getValue() instanceof String) {
            obj.setDescription((String)member.getValue());
          }
          break;
        case "id":
          if (member.getValue() instanceof Number) {
            obj.setId(((Number)member.getValue()).intValue());
          }
          break;
        case "info":
          if (member.getValue() instanceof JsonObject) {
            java.util.Map<String, java.lang.Object> map = new java.util.LinkedHashMap<>();
            ((Iterable<java.util.Map.Entry<String, Object>>)member.getValue()).forEach(entry -> {
              if (entry.getValue() instanceof Object)
                map.put(entry.getKey(), entry.getValue());
            });
            obj.setInfo(map);
          }
          break;
        case "label":
          if (member.getValue() instanceof String) {
            obj.setLabel((String)member.getValue());
          }
          break;
        case "location":
          if (member.getValue() instanceof String) {
            obj.setLocation((String)member.getValue());
          }
          break;
        case "name":
          if (member.getValue() instanceof String) {
            obj.setName((String)member.getValue());
          }
          break;
        case "posx":
          if (member.getValue() instanceof Number) {
            obj.setPosx(((Number)member.getValue()).intValue());
          }
          break;
        case "posy":
          if (member.getValue() instanceof Number) {
            obj.setPosy(((Number)member.getValue()).intValue());
          }
          break;
        case "status":
          if (member.getValue() instanceof String) {
            obj.setStatus((String)member.getValue());
          }
          break;
        case "type":
          if (member.getValue() instanceof String) {
            obj.setType((String)member.getValue());
          }
          break;
        case "updated":
          if (member.getValue() instanceof String) {
            obj.setUpdated((String)member.getValue());
          }
          break;
        case "vltps":
          if (member.getValue() instanceof JsonArray) {
            java.util.ArrayList<io.nms.central.microservice.topology.model.Vltp> list =  new java.util.ArrayList<>();
            ((Iterable<Object>)member.getValue()).forEach( item -> {
              if (item instanceof JsonObject)
                list.add(new io.nms.central.microservice.topology.model.Vltp((JsonObject)item));
            });
            obj.setVltps(list);
          }
          break;
        case "vsubnetId":
          if (member.getValue() instanceof Number) {
            obj.setVsubnetId(((Number)member.getValue()).intValue());
          }
          break;
        case "vxcs":
          if (member.getValue() instanceof JsonArray) {
            java.util.ArrayList<io.nms.central.microservice.topology.model.Vxc> list =  new java.util.ArrayList<>();
            ((Iterable<Object>)member.getValue()).forEach( item -> {
              if (item instanceof JsonObject)
                list.add(new io.nms.central.microservice.topology.model.Vxc((JsonObject)item));
            });
            obj.setVxcs(list);
          }
          break;
      }
    }
  }

  public static void toJson(Vnode obj, JsonObject json) {
    toJson(obj, json.getMap());
  }

  public static void toJson(Vnode obj, java.util.Map<String, Object> json) {
    if (obj.getCreated() != null) {
      json.put("created", obj.getCreated());
    }
    if (obj.getDescription() != null) {
      json.put("description", obj.getDescription());
    }
    json.put("id", obj.getId());
    if (obj.getInfo() != null) {
      JsonObject map = new JsonObject();
      obj.getInfo().forEach((key, value) -> map.put(key, value));
      json.put("info", map);
    }
    if (obj.getLabel() != null) {
      json.put("label", obj.getLabel());
    }
    if (obj.getLocation() != null) {
      json.put("location", obj.getLocation());
    }
    if (obj.getName() != null) {
      json.put("name", obj.getName());
    }
    if (obj.getPosx() != null) {
      json.put("posx", obj.getPosx());
    }
    if (obj.getPosy() != null) {
      json.put("posy", obj.getPosy());
    }
    if (obj.getStatus() != null) {
      json.put("status", obj.getStatus());
    }
    if (obj.getType() != null) {
      json.put("type", obj.getType());
    }
    if (obj.getUpdated() != null) {
      json.put("updated", obj.getUpdated());
    }
    if (obj.getVltps() != null) {
      JsonArray array = new JsonArray();
      obj.getVltps().forEach(item -> array.add(item.toJson()));
      json.put("vltps", array);
    }
    json.put("vsubnetId", obj.getVsubnetId());
    if (obj.getVxcs() != null) {
      JsonArray array = new JsonArray();
      obj.getVxcs().forEach(item -> array.add(item.toJson()));
      json.put("vxcs", array);
    }
  }
}
