package uz.muhandis.stockservcie.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private String orderId;
    private String orderName;
    private Integer quantity;
    private Double orderPrice;

}
