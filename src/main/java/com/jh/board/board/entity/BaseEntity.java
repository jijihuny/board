package com.jh.board.board.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public abstract class BaseEntity {
    
    @CreationTimestamp // inserted time stamp.
    @Column(updatable = false)
    private LocalDateTime createTime;

    @UpdateTimestamp
    @Column(insertable = false)
    private LocalDateTime updateTime;
}
