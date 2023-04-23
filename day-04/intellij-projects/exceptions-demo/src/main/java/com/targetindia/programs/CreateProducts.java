package com.targetindia.programs;

import com.targetindia.exceptions.BlankNameException;
import com.targetindia.exceptions.InvalidIdException;
import com.targetindia.exceptions.InvalidPriceException;
import com.targetindia.exceptions.NullNameException;
import com.targetindia.model.Product;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CreateProducts {
    public static void main(String[] args) {
        log.trace("starting to execute main()");

        try {
            Product p1;
            p1 = new Product();
            log.trace("new Product created");
            p1.setId(-123);
            log.trace("assigned {} to p1.id", p1.getId());
            p1.setName("Lenovo thinkpad laptop");
            log.trace("assigned {} to p1.name", p1.getName());
            p1.setPrice(145000.0);
            log.trace("assigned {} to p1.price", p1.getPrice());
            log.trace("laptop details - {}", p1);
        } catch (InvalidIdException e) {
            log.warn("Invalid id supplied");
        } catch (InvalidPriceException e) {
            log.warn(e.getMessage());
        } catch (BlankNameException | NullNameException e) {
            log.warn("Product name cannot be null or blank!");
        } catch (Exception e) {
            log.warn("There was an error - {}", e.getMessage());
        }

        log.trace("main() execution is finished");
    }
}
