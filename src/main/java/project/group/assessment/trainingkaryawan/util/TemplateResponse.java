package project.group.assessment.trainingkaryawan.util;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class TemplateResponse {

    public Map success(Object obj) {
        Map map = new HashMap();
        map.put("data", obj);
        map.put("status", "sukses");
        map.put("code", "200");
        return map;
    }

    public Map error(Object obj) {
        Map map = new HashMap();
        map.put("status", obj);
        map.put("code", "400");
        return map;
    }

    public Map notFound(Object obj) {
        Map map = new HashMap();
        map.put("status", obj);
        map.put("code", "404");
        return map;
    }

    public boolean checkNull(Object obj) {
        if (obj == null) {
            return true;
        }
        return false;
    }

}
