package com.sageconsulting.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author PIYUSH
 * 
 * @hibernate.class table="match_category"
 */
public class MatchCategory extends BaseObject implements Serializable {

	private static final long serialVersionUID = -8801295306371028090L;

	private Long id;
	private Integer version;
	private City city;
	private String name;
	//private SortedSet<Match> matches;

	/**
	 * @hibernate.id column="id" generator-class="native" unsaved-value="null"
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * @hibernate.version
	 */
	public Integer getVersion() {
		return this.version;
	}

	/**
	 * 
	 * @return
	 * 
	 * @hibernate.many-to-one column="city_id" not-null="true"
	 */
	public City getCity() {
		return this.city;
	}

	/**
	 * @hibernate.property column="name" unique="false"
	 */
	public String getName() {
		return this.name;
	}

	

	public void setId(Long i) {
		this.id = i;
	}

	public void setVersion(Integer ver) {
		this.version = ver;
	}

	public void setCity(City c) {
		this.city = c;
	}

	public void setName(String n) {
		this.name = n;
	}

	@Override
	public String toString() {

		ToStringBuilder sb = new ToStringBuilder(this,
				ToStringStyle.MULTI_LINE_STYLE);
		sb.append("name", this.name);
		sb.append("city", this.city);
		/*for (Match match : this.matches) {
			sb.append(match);
		}*/
		return sb.toString();

	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof MatchCategory))
			return false;

		final MatchCategory matchCategory = (MatchCategory) o;
		return matchCategory.id.equals(this.id);
	}

	@Override
	public int hashCode() {
		return this.name.hashCode();
	}

}
