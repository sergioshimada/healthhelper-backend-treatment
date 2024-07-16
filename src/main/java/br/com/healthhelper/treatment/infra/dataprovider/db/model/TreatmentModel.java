package br.com.healthhelper.treatment.infra.dataprovider.db.model;

import br.com.healthhelper.treatment.commons.enumerator.TreatmentTypeEnum;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Table(name = "treatment")
@EntityListeners(AuditingEntityListener.class)
public class TreatmentModel {

	@Id
	@GeneratedValue(generator = "treatment.treatment_generator")
	@SequenceGenerator(name = "treatment.treatment_generator", sequenceName = "treatment.treatment_sequence")
	private Long id;
	private UUID uuid;
	private String name;
	private String description;
	private BigDecimal value;
	@Enumerated(EnumType.STRING)
	private TreatmentTypeEnum type;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "creation_date", nullable = false, updatable = false)
	@CreatedDate
	private Date creationDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_update", nullable = false)
	@LastModifiedDate
	private Date lastUpdate;
}
