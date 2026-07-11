package com.modularmonolithmsaarchitecture;

import com.modularmonolithmsaarchitecture.cart.Cart;
import com.modularmonolithmsaarchitecture.cart.CartItem;
import com.modularmonolithmsaarchitecture.cart.CartRepository;
import com.modularmonolithmsaarchitecture.product.Product;
import com.modularmonolithmsaarchitecture.product.ProductRepository;
import com.modularmonolithmsaarchitecture.seller.Seller;
import com.modularmonolithmsaarchitecture.seller.SellerRepository;
import com.modularmonolithmsaarchitecture.user.User;
import com.modularmonolithmsaarchitecture.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final SellerRepository sellerRepository;
    private final ProductRepository productRepository;
    private final CartRepository cartRepository;

    @Override
    public void run(String... args) throws Exception {
        User buyer = userRepository.save(
                User.register("buyer@growmighty.co.kr", "encoded-pw", "구매자", "010-1111-1111"));
        User sellerOwner = userRepository.save(
                User.register("seller@growmighty.co.kr", "encoded-pw", "판매자", "010-2222-2222"));

        Seller seller = sellerRepository.save(Seller.create(sellerOwner));

        Product chair = productRepository.save(
                Product.create(seller, "Dofia 이동식 접이식 식탁 의자 4개 세트", BigDecimal.valueOf(179000), 10, "가정용 소형주택 신축식"));
        Product table = productRepository.save(
                Product.create(seller, "원목 4인용 식탁", BigDecimal.valueOf(259000), 5, "북유럽 스타일 원목 식탁"));

        Cart cart = Cart.create(buyer);
        cart.addItem(CartItem.create(chair, 2));
        cart.addItem(CartItem.create(table, 1));
        cartRepository.save(cart);

        System.out.printf(
                "[seed] 구매자 id=%d, 장바구니 id=%d 준비 완료. 예) POST /orders?userId=%d%n",
                buyer.getId(), cart.getId(), buyer.getId());
    }
}
