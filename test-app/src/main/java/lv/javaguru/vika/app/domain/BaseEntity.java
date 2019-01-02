package lv.javaguru.vika.app.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@MappedSuperclass
public class BaseEntity {

    @Version
    @Column(name = "version", nullable = false)
    private Long version = 0L;

    @Column(name = "created_at", nullable = false)
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name = "modified_at")
    @LastModifiedDate
    private LocalDateTime modifiedAt;

    @PrePersist
    protected void updateCreatedAt() {
        createdAt = LocalDateTime.now(ZoneOffset.UTC);
    }

    @PreUpdate
    protected void updateModifiedAt() {
        modifiedAt = LocalDateTime.now(ZoneOffset.UTC);
    }

	public Long getVersion() {
		return version;
	}
    

}
