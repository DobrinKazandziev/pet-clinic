package dobrink.petclinic.bootsrap;

import com.github.javafaker.Faker;
import dobrink.petclinic.model.Owner;
import dobrink.petclinic.model.Vet;
import dobrink.petclinic.services.OwnerService;
import dobrink.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.LongStream;

@Component
public class DataLoader implements CommandLineRunner {

  private final OwnerService ownerService;
  private final VetService vetService;
  private final Faker faker;

  public DataLoader(OwnerService ownerService, VetService vetService) {
    this.ownerService = ownerService;
    this.vetService = vetService;
    this.faker = new Faker();
  }

  @Override
  public void run(String... args) throws Exception {
    LongStream.rangeClosed(1, 2)
            .mapToObj(this::createFakeOwner)
            .forEach(ownerService::save);
    System.out.println("Loaded owners...");

    LongStream.rangeClosed(1, 2)
            .mapToObj(this::createFakeVet)
            .forEach(vetService::save);
    System.out.println("Loaded vets...");
  }

  private Vet createFakeVet(Long id) {
    Vet vet = new Vet();

    vet.setId(id);
    vet.setFirstName(faker.name().firstName());
    vet.setLastName(faker.name().lastName());

    return vet;
  }

  private Owner createFakeOwner(Long id) {
    Owner owner = new Owner();

    owner.setId(id);
    owner.setFirstName(faker.name().firstName());
    owner.setLastName(faker.name().lastName());

    return owner;
  }
// Hardcoded Impl
//  @Override
//  public void run(String... args) throws Exception {
//
//    Owner owner1 = new Owner();
//    owner1.setId(1L);
//    owner1.setFirstName("Michael");
//    owner1.setLastName("Weston");
//
//    ownerService.save(owner1);
//
//    Owner owner2 = new Owner();
//    owner2.setId(2L);
//    owner2.setFirstName("Fiona");
//    owner2.setLastName("Glenanne");
//
//    ownerService.save(owner2);
//
//    System.out.println("Loaded Owners...");
//
//    Vet vet1 = new Vet();
//    vet1.setId(1L);
//    vet1.setFirstName("Sam");
//    vet1.setLastName("Axe");
//
//    vetService.save(vet1);
//
//    Vet vet2 = new Vet();
//    vet2.setId(2L);
//    vet2.setFirstName("Jessie");
//    vet2.setLastName("Porter");
//
//    vetService.save(vet2);
//
//    System.out.println("Loader Vets....");
//  }
}
