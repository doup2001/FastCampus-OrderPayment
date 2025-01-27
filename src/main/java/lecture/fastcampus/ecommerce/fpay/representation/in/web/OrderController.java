package lecture.fastcampus.ecommerce.fpay.representation.in.web;

import jakarta.validation.Valid;
import lecture.fastcampus.ecommerce.fpay.application.port.in.CreateNewOrderUseCase;
import lecture.fastcampus.ecommerce.fpay.application.port.in.GetOrderInfoUseCase;
import lecture.fastcampus.ecommerce.fpay.representation.request.order.PurchaseOrder;
import lecture.fastcampus.ecommerce.fpay.representation.response.NewPurchaseOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final CreateNewOrderUseCase createNewOrderUseCase;
    private final GetOrderInfoUseCase getOrderInfoUseCase;

    @PostMapping("/new")
    public NewPurchaseOrder newOrder(@RequestBody @Valid PurchaseOrder newOrder) throws Exception {
        return NewPurchaseOrder.from(createNewOrderUseCase.createOrder(newOrder));
    }

    @GetMapping
    public String test() throws Exception {
        return "test";
    }

    @GetMapping("/info")
    public  Map<String, String> requestParams(@RequestParam(value = "username") String username){
        Map<String, String> params = new HashMap<>();
        params.put("username", username);
        return params;
    }

    @GetMapping("/query")
    public NewPurchaseOrder getOrderById(@RequestParam(value = "order_id") UUID orderId){
        return NewPurchaseOrder.from(getOrderInfoUseCase.getOrderInfo(orderId));
    }

}
