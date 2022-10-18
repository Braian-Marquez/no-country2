package com.pixiesarg.back.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE users SET soft_delete = true WHERE id=?")
@Where(clause = "soft_delete=false")
@Table(name = "USERS", indexes = @Index(name = "email", columnList = "email", unique = true))
public class UserEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    private String username = email;

    @Column(name = "password", nullable = false)
    private String password;

    private String country;

    @Column(name = "money")
    private Long money;

    @ElementCollection(targetClass=Long.class)
    private List<Long> idFavorite;

    private Long likes;

    @OneToOne
    private AvatarEntity avatar;

    @OneToMany
    private List<AssetsEntity> inventory;


    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<RoleEntity> roles;

    @ManyToOne
    private StoreEntity store;

    @CreationTimestamp
    @Column(name = "create_timestamp")
    private Timestamp createTimestamp;

    @Column(name = "soft_delete")
    private Boolean softDelete = Boolean.FALSE;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return !this.softDelete;
    }
}
