///:TreeController.java
package club.weyoung.commonapi.web;

import club.weyoung.commonapi.vo.EasyUiTree;
import club.weyoung.commonapi.vo.SimpleTree;
import club.weyoung.commonapi.vo.StandardTree;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author icechen1219
 * @date 2019/05/21
 */
@Api(tags = "树形菜单测试接口")
@RestController
public class TreeController {
    private Logger logger = LoggerFactory.getLogger(TreeController.class);


    @ApiOperation("简单数据接口")
    @GetMapping("/simple/treeNodes")
    public List<SimpleTree> simpleData() {
        String data = "[{ \"id\":1, \"pId\":0, \"name\":\"父节点1 - 展开\", \"open\":true},\n" +
                "  { \"id\":11, \"pId\":1, \"name\":\"父节点11 - 折叠\"},\n" +
                "  { \"id\":111, \"pId\":11, \"name\":\"叶子节点111\"},\n" +
                "  { \"id\":112, \"pId\":11, \"name\":\"叶子节点112\"},\n" +
                "  { \"id\":113, \"pId\":11, \"name\":\"叶子节点113\"},\n" +
                "  { \"id\":114, \"pId\":11, \"name\":\"叶子节点114\"},\n" +
                "  { \"id\":12, \"pId\":1, \"name\":\"父节点12 - 折叠\"},\n" +
                "  { \"id\":121, \"pId\":12, \"name\":\"叶子节点121\"},\n" +
                "  { \"id\":122, \"pId\":12, \"name\":\"叶子节点122\"},\n" +
                "  { \"id\":123, \"pId\":12, \"name\":\"叶子节点123\"},\n" +
                "  { \"id\":124, \"pId\":12, \"name\":\"叶子节点124\"},\n" +
                "  { \"id\":13, \"pId\":1, \"name\":\"父节点13 - 没有子节点\", \"isParent\":true},\n" +
                "  { \"id\":2, \"pId\":0, \"name\":\"父节点2 - 折叠\"},\n" +
                "  { \"id\":21, \"pId\":2, \"name\":\"父节点21 - 展开\", \"open\":true},\n" +
                "  { \"id\":211, \"pId\":21, \"name\":\"叶子节点211\"},\n" +
                "  { \"id\":212, \"pId\":21, \"name\":\"叶子节点212\"},\n" +
                "  { \"id\":213, \"pId\":21, \"name\":\"叶子节点213\"},\n" +
                "  { \"id\":214, \"pId\":21, \"name\":\"叶子节点214\"},\n" +
                "  { \"id\":22, \"pId\":2, \"name\":\"父节点22 - 折叠\"},\n" +
                "  { \"id\":221, \"pId\":22, \"name\":\"叶子节点221\"},\n" +
                "  { \"id\":222, \"pId\":22, \"name\":\"叶子节点222\"},\n" +
                "  { \"id\":223, \"pId\":22, \"name\":\"叶子节点223\"},\n" +
                "  { \"id\":224, \"pId\":22, \"name\":\"叶子节点224\"},\n" +
                "  { \"id\":23, \"pId\":2, \"name\":\"父节点23 - 折叠\"},\n" +
                "  { \"id\":231, \"pId\":23, \"name\":\"叶子节点231\"},\n" +
                "  { \"id\":232, \"pId\":23, \"name\":\"叶子节点232\"},\n" +
                "  { \"id\":233, \"pId\":23, \"name\":\"叶子节点233\"},\n" +
                "  { \"id\":234, \"pId\":23, \"name\":\"叶子节点234\"},\n" +
                "  { \"id\":3, \"pId\":0, \"name\":\"父节点3 - 没有子节点\", \"isParent\":true}\n" +
                "]";
        List<SimpleTree> simpleTrees = JSON.parseArray(data, SimpleTree.class);
        return simpleTrees;
    }

    @ApiOperation("根据ID查询某个节点")
    @GetMapping("/simple/treeNode/{id}")
    public SimpleTree simpleData(@PathVariable("id") Integer id) {
        List<SimpleTree> simpleTrees = simpleData();
        for (SimpleTree simpleTree : simpleTrees) {
            if (simpleTree.getId().equals(id)) {
                return simpleTree;
            }
        }
        return null;
    }

    @ApiOperation("标准数据接口")
    @GetMapping("/standard/treeNodes")
    public List<StandardTree> standardData() {
        String data = "[\n" +
                "  { \"name\":\"父节点1 - 展开\", \"open\":true,\n" +
                "    \"children\": [\n" +
                "      { \"name\":\"父节点11 - 折叠\",\n" +
                "        \"children\": [\n" +
                "          { \"name\":\"叶子节点111\",\"url\":\"http://www.baidu.com\"},\n" +
                "          { \"name\":\"叶子节点112\"},\n" +
                "          { \"name\":\"叶子节点113\"},\n" +
                "          { \"name\":\"叶子节点114\"}\n" +
                "        ]},\n" +
                "      { \"name\":\"父节点12 - 折叠\",\n" +
                "        \"children\": [\n" +
                "          { \"name\":\"叶子节点121\"},\n" +
                "          { \"name\":\"叶子节点122\"},\n" +
                "          { \"name\":\"叶子节点123\"},\n" +
                "          { \"name\":\"叶子节点124\"}\n" +
                "        ]},\n" +
                "      { \"name\":\"父节点13 - 没有子节点\", \"isParent\":true}\n" +
                "    ]},\n" +
                "  { \"name\":\"父节点2 - 折叠\",\n" +
                "    \"children\": [\n" +
                "      { \"name\":\"父节点21 - 展开\", \"open\":true,\n" +
                "        \"children\": [\n" +
                "          { \"name\":\"叶子节点211\"},\n" +
                "          { \"name\":\"叶子节点212\"},\n" +
                "          { \"name\":\"叶子节点213\"},\n" +
                "          { \"name\":\"叶子节点214\"}\n" +
                "        ]},\n" +
                "      { \"name\":\"父节点22 - 折叠\",\n" +
                "        \"children\": [\n" +
                "          { \"name\":\"叶子节点221\"},\n" +
                "          { \"name\":\"叶子节点222\"},\n" +
                "          { \"name\":\"叶子节点223\"},\n" +
                "          { \"name\":\"叶子节点224\"}\n" +
                "        ]},\n" +
                "      { \"name\":\"父节点23 - 折叠\",\n" +
                "        \"children\": [\n" +
                "          { \"name\":\"叶子节点231\"},\n" +
                "          { \"name\":\"叶子节点232\"},\n" +
                "          { \"name\":\"叶子节点233\"},\n" +
                "          { \"name\":\"叶子节点234\"}\n" +
                "        ]}\n" +
                "    ]},\n" +
                "  { \"name\":\"父节点3 - 没有子节点\", \"isParent\":true}\n" +
                "\n" +
                "]";

        List<StandardTree> standardTrees = JSON.parseArray(data, StandardTree.class);
        return standardTrees;
    }


    @ApiOperation("EasyUI测试接口")
    @GetMapping("/easyui/treeNodes")
    public List<EasyUiTree> easyUiData() {
        String data = "[\n" +
                "  {\n" +
                "    \"id\": 1,\n" +
                "    \"text\": \"指标管理\",\n" +
                "    \"iconCls\": \"icon-save\",\n" +
                "    \"children\": [\n" +
                "      {\n" +
                "        \"text\": \"学生评价指标\",\n" +
                "        \"checked\": true\n" +
                "      },\n" +
                "      {\n" +
                "        \"text\": \"系主任评价指标\",\n" +
                "        \"state\": \"open\",\n" +
                "        \"attributes\": {\n" +
                "          \"url\": \"_content.html\"\n" +
                "        }\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"text\": \"评教进度管理\",\n" +
                "    \"state\": \"closed\",\n" +
                "    \"children\": [\n" +
                "      {\n" +
                "        \"text\": \"当前评教\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"text\": \"评教结果\",\n" +
                "        \"attributes\":{\n" +
                "          \"url\":\"_result.html\"\n" +
                "        }\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "]";

        List<EasyUiTree> easyUiTrees = JSON.parseArray(data, EasyUiTree.class);
        return easyUiTrees;
    }
}
///:TreeController.java
