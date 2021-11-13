package fr.formation.Gardens.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

public class UpdateGardenDto {
	@NotEmpty(message = "{E_NOT_EMPTY}")
	@Size(max = 50, message = "{E_MAX_LENGTH_EXCEEDED}")
	private String name;
	@NotNull(message = "{E_NOT_EMPTY}")
	@Range(min = 1, max = 1000, message = "{E_MAX_LENGTH_EXCEEDED}")
	private double size;
	@NotEmpty(message = "{E_NOT_EMPTY}")
	@Size(max = 50, message = "{E_MAX_LENGTH_EXCEEDED}")
	private String localisation;
	@NotEmpty(message = "{E_NOT_EMPTY}")
	@Size(max = 50, message = "{E_MAX_LENGTH_EXCEEDED}")
	private String typeOfGarden;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public String getLocalisation() {
		return localisation;
	}

	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}

	public String getTypeOfGarden() {
		return typeOfGarden;
	}

	public void setTypeOfGarden(String typeOfGarden) {
		this.typeOfGarden = typeOfGarden;
	}
}
