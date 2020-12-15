# BigProject
#json格式字符串转map
Map<String, Object> jsonStringToMap = JSONObject.parseObject("String", new TypeReference<Map<String, Object>>() {});
#map转实体类
public static <T,R> R copyProperties(T source,R target){
        return copyProperties(source,target,null);
    }
public static <T,R> R copyProperties(T source, R target, Converter converter){
        BeanCopier copier = BeanCopier.create(source.getClass(), target.getClass(), converter!=null);
        copier.copy(source, target, converter);
        return target;
    }
