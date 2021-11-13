package fr.formation.Gardens.dtos;

public interface GardenViewDto {

	Long getId();

	String getName();

	double getSize();

	String getLocalisation();

	String getTypeOfGarden();

	UserViewDto getUser();

	AddressViewDto getAddress();

	ProfilViewDto getProfil();

}
