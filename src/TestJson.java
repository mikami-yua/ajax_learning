import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Province;

public class TestJson {
    public static void main(String[] args) throws JsonProcessingException {
        //使用jackson把java对象转换为json格式的字符串
        Province province=new Province();
        province.setId(1);
        province.setName("河北");
        province.setJiancheng("冀");
        province.setShenghui("石家庄");

        ObjectMapper om=new ObjectMapper();
        String json = om.writeValueAsString(province);//方法的返回值是个string，就是参数对象对应的json格式的字符串
        System.out.println("转换的json== "+json);//转换的json== {"id":1,"name":"河北","jiancheng":"冀","shenghui":"石家庄"}
    }
}
