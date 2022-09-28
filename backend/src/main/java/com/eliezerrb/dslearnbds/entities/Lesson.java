package com.eliezerrb.dslearnbds.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// @Inheritance - anotação porque é super classe strategy decisão se será uma tabela ou tabelas separadas
// JOINED - Criar várias tabelas
// SINGLE_TABLE - Uma tabela
// TABLE_PER_CLASS - Não cria a tabela da super classe, repeti as colunas da super classe nas filhas

@Entity
@Table(name = "tb_lesson")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Lesson implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	private Integer position;
	
	@ManyToOne
	@JoinColumn(name = "section_id")
	private Section section;
	
	/*
	 * Associação com Enrollment 
	 * @JoinTable(tabela que faz a associação entre as duas entidades)
	 * name(nome da tabela que faz o relacionamento)
	 * joinColumns(vai dizer as duas chaves estrangeiras)
	 * @JoinColumn(vai estabelecer qual vai ser a chave estrangeira relacionada a classe onde estou, ex Lesson)
	 * inverseJoinColumns(vai dizer a chave estrangeira que faz o outro lado da assossiação muitos para muitos)
	 *      nesse caso como Enrollment tem chave composta foram dois @JoinColumn
	 */
	
	@ManyToMany
	@JoinTable(name = "tb_lessons_done",
			joinColumns = @JoinColumn(name = "lesson_id"),
			inverseJoinColumns = {
					@JoinColumn(name = "user_id"),
					@JoinColumn(name = "offer_id")
			}
	)
	private Set<Enrollment> enrollmentsDone = new HashSet<>();
	
	public Lesson() {
	}

	public Lesson(Long id, String title, Integer position, Section section) {
		super();
		this.id = id;
		this.title = title;
		this.position = position;
		this.section = section;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public Set<Enrollment> getEnrollmentsDone() {
		return enrollmentsDone;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lesson other = (Lesson) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
