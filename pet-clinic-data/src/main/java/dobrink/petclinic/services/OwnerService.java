package dobrink.petclinic.services;

import dobrink.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

  Owner findByLastName(String lastName);

}
