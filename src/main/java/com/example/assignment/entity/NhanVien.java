package com.example.assignment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "NhanVien")
public class NhanVien {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "uniqueidentifier default newid()")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "IDCV")
    private ChucVu chucVu;

    @Column(name = "Ma")
    private String maNV;

    @Column(name = "Ho")
    private String tenHo;

    @Column(name = "TenDem")
    private String tenDem;

    @Column(name = "Ten")
    private String tenNV;

    @Column(name = "gioiTinh")
    private Boolean gioiTinh;

    @Column(name = "MatKhau")
    private String matKhau;

    @Column(name = "trangThai")
    private Integer trangThai;

    @Column(name = "DiaChi")
    private String diaChi;

}
