import com.google.gson.Gson;
import com.myGroup1.Logic;
import com.myGroup1.Models.OrderModel;
import com.myGroup1.Models.PickerModel;
import com.myGroup1.Models.StoreModel;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import com.myGroup1.Application;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import com.myGroup1.Application;
public class JUnitTest {

//      Well I tried but im not good with tests yet, but I'll learn

//    @DisplayName("CheckIfAssignedCorrect")
//    @Test
//    public void test() throws IOException {
//        Gson gson = new Gson();
//        List<OrderModel> orders = new ArrayList<>();
//        List<StoreModel> stores = new ArrayList<>();
//        List<PickerModel> pickers = new ArrayList<>();
//        Application.main(new String[]{"self-test-data/complete-by/orders.json", "self-test-data/complete-by/store.json"});
//        List<String> resultLines = null;
//        try {
//            resultLines = Files.readAllLines(Path.of("self-test-data/complete-by/output.txt"));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        Logic.assignPicker(pickers,orders);
//        Assertions.assertArrayEquals(resultLines,Application.main(new String[]{"self-test-data/complete-by/orders.json", "self-test-data/complete-by/store.json"}));
//
//    }
}
