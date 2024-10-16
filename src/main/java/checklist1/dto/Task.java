package checklist1.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;
@Entity
@Data
public class Task {
	@Id
	@GeneratedValue(generator="abc")
	@SequenceGenerator(initialValue = 100,allocationSize = 1,name = "abc")
private int tid;
private String tName;
private String tDescription;
@CreationTimestamp
private Date cT;
private boolean status;
@ManyToOne
private User user;
}
