package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // inserts new inventory if in house parts repository is empty
        if (partRepository.count() == 0) {
            // inserts human girl body into part repository
            InhousePart humanGirlBody = new InhousePart();
            humanGirlBody.setPartId(000);
            humanGirlBody.setName("Human Girl Body");
            humanGirlBody.setInv(25);
            humanGirlBody.setPrice(15.00);
            humanGirlBody.setMinInv(5);
            humanGirlBody.setMaxInv(50);
            partRepository.save(humanGirlBody);

            // inserts human boy body into part repository
            InhousePart humanBoyBody = new InhousePart();
            humanBoyBody.setPartId(001);
            humanBoyBody.setName("Human Boy Body");
            humanBoyBody.setInv(25);
            humanBoyBody.setPrice(15.00);
            humanBoyBody.setMinInv(5);
            humanBoyBody.setMaxInv(50);
            partRepository.save(humanBoyBody);

            // inserts teddy bear body into part repository
            InhousePart teddyBearBody = new InhousePart();
            teddyBearBody.setPartId(002);
            teddyBearBody.setName("Teddy Bear Body");
            teddyBearBody.setInv(25);
            teddyBearBody.setPrice(20.00);
            teddyBearBody.setMinInv(5);
            teddyBearBody.setMaxInv(50);
            partRepository.save(teddyBearBody);
        }

        // inserts outsourced parts if repository is empty
        if (outsourcedPartRepository.count() == 0) {
            // inserts black shirt into repository
            OutsourcedPart blackShirt = new OutsourcedPart();
            blackShirt.setId(100);
            blackShirt.setName("Black Shirt");
            blackShirt.setInv(10);
            blackShirt.setPrice(3.00);
            blackShirt.setMinInv(5);
            blackShirt.setMaxInv(50);
            blackShirt.setCompanyName("Doll Clothes Inc.");
            outsourcedPartRepository.save(blackShirt);

            // inserts red shirt into repository
            OutsourcedPart redShirt = new OutsourcedPart();
            redShirt.setId(101);
            redShirt.setName("Red Shirt");
            redShirt.setInv(10);
            redShirt.setPrice(5.00);
            redShirt.setMinInv(5);
            redShirt.setMaxInv(50);
            redShirt.setCompanyName("Doll Clothes Inc.");
            outsourcedPartRepository.save(redShirt);

            // inserts blue shirt into repository
            OutsourcedPart blueShirt = new OutsourcedPart();
            blueShirt.setId(102);
            blueShirt.setName("Blue Shirt");
            blueShirt.setInv(10);
            blueShirt.setPrice(5.00);
            blueShirt.setMinInv(5);
            blueShirt.setMaxInv(50);
            blueShirt.setCompanyName("Doll Clothes Inc.");
            outsourcedPartRepository.save(blueShirt);

            // inserts black pants into repository
            OutsourcedPart blackPants = new OutsourcedPart();
            blackPants.setId(200);
            blackPants.setName("Black Pants");
            blackPants.setInv(10);
            blackPants.setPrice(7.00);
            blackPants.setMinInv(5);
            blackPants.setMaxInv(50);
            blackPants.setCompanyName("Doll Clothes Inc.");
            outsourcedPartRepository.save(blackPants);

            // inserts denim pants into repository
            OutsourcedPart denimPants = new OutsourcedPart();
            denimPants.setId(201);
            denimPants.setName("Denim Pants");
            denimPants.setInv(10);
            denimPants.setPrice(12.00);
            denimPants.setMinInv(5);
            denimPants.setMaxInv(50);
            denimPants.setCompanyName("Doll Clothes Inc.");
            outsourcedPartRepository.save(denimPants);

            // inserts glasses into repository
            OutsourcedPart glasses = new OutsourcedPart();
            glasses.setId(300);
            glasses.setName("Glasses");
            glasses.setInv(10);
            glasses.setPrice(10.00);
            glasses.setMinInv(5);
            glasses.setMaxInv(50);
            glasses.setCompanyName("Doll Clothes Inc.");
            outsourcedPartRepository.save(glasses);

            // inserts sunglasses into repository
            OutsourcedPart sunglasses = new OutsourcedPart();
            sunglasses.setId(301);
            sunglasses.setName("Sunglasses");
            sunglasses.setInv(10);
            sunglasses.setPrice(10.00);
            sunglasses.setMinInv(5);
            sunglasses.setMaxInv(50);
            sunglasses.setCompanyName("Doll Clothes Inc.");
            outsourcedPartRepository.save(sunglasses);

            // inserts bow into repository
            OutsourcedPart bow = new OutsourcedPart();
            bow.setId(302);
            bow.setName("Bow");
            bow.setInv(10);
            bow.setPrice(5.00);
            bow.setMinInv(5);
            bow.setMaxInv(50);
            bow.setCompanyName("Doll Clothes Inc.");
            outsourcedPartRepository.save(bow);
        }

        // inserts products if repository is empty
        if (productRepository.count() == 0) {
            // inserts Studious Girl - a pre-made doll - into the repository
            // NOTE: does not set associated parts
            Product studiousGirl = new Product(400, "Studious Girl", 45.00, 5);
            productRepository.save(studiousGirl);

            // inserts Studious Boy - a pre-made doll - into the repository
            // NOTE: does not set associated parts
            Product studiousBoy = new Product(401, "Studious Boy", 45.00, 5);
            productRepository.save(studiousBoy);

            // inserts Studious Teddy - a pre-made doll - into the repository
            // NOTE: does not set associated parts
            Product studiousTeddy = new Product(402, "Studious Teddy", 50.00, 5);
            productRepository.save(studiousTeddy);

            // inserts Cool Girl - a pre-made doll - into the repository
            // NOTE: does not set associated parts
            Product coolGirl = new Product(403, "Cool Girl", 45.00, 5);
            productRepository.save(coolGirl);

            // inserts Cool Boy - a pre-made doll - into the repository
            // NOTE: does not set associated parts
            Product coolBoy = new Product(404, "Cool Boy", 45.00, 5);
            productRepository.save(coolBoy);

            // inserts Cool Teddy - a pre-made doll - into the repository
            // NOTE: does not set associated parts
            Product coolTeddy = new Product(405, "Cool Teddy", 50.00, 5);
            productRepository.save(coolTeddy);
        }
       /*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
        */
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }

        /*
        Product bicycle= new Product("bicycle",100.0,15);
        Product unicycle= new Product("unicycle",100.0,15);
        productRepository.save(bicycle);
        productRepository.save(unicycle);
        */

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
