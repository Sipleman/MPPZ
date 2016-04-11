package Model.Entity;

import javax.persistence.*;

/**
 * Created by xoll on 11.04.16.
 */
@Entity
@Table(name = "Queries", schema = "mydb", catalog = "")
public class QueriesEntity {
    private int idQuery;
    private MethodicsEntity method;
    private CoordinationResultsEntity coordinationResult;
    private TypesOfQueriesEntity type;

    @Id
    @Column(name = "idQuery")
    public int getIdQuery() {
        return idQuery;
    }

    public void setIdQuery(int idQuery) {
        this.idQuery = idQuery;
    }

    @OneToOne(targetEntity = CoordinationResultsEntity.class,
            fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "idResult")
    public CoordinationResultsEntity getCoordinationResult() {
        return coordinationResult;
    }

    public void setCoordinationResult(CoordinationResultsEntity coordinationResult) {
        this.coordinationResult = coordinationResult;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idMethodic")
    public MethodicsEntity getMethod() {
        return method;
    }

    public void setMethod(MethodicsEntity method) {
        this.method = method;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QueriesEntity that = (QueriesEntity) o;

        if (idQuery != that.idQuery) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return idQuery;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "idQueryType")
    public TypesOfQueriesEntity getType() {
        return type;
    }

    public void setType(TypesOfQueriesEntity type) {
        this.type = type;
    }
}