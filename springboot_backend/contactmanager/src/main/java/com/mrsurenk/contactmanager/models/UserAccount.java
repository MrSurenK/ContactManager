package com.mrsurenk.contactmanager.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class UserAccount implements UserDetails {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @OneToMany(mappedBy= Contacts_.USER_ACCOUNT)
    private Set<Contacts> contactOwner;

    @OneToMany(mappedBy=Contacts_.FRIEND_ACCOUNT)
    private Set<Contacts> friendAcc;

    @Column(unique = true)
    private String email;

    private String name;

    @Column(length = 72)
    private String password;

    private String contact;

    private LocalDate lastLogin;

    private String displayPic;

    private boolean hidden;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
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
        return true;
    }
}
