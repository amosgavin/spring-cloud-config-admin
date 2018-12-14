package com.didispace.scca.core.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 项目
 * <p>
 * Created by 程序猿DD/翟永超 on 2018/5/21.
 * <p>
 * Blog: http://blog.didispace.com/
 * Github: https://github.com/dyc87112/
 */
@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = {"envs", "labels"})
public class Project {

    @Id
    @GeneratedValue
    private Long id;

    /**
     * 项目名
     */
    @Column(unique = true)
    private String name;

    /**
     * 配置文件路径，相对根目录
     */
    @Column
    private String confPath;

    /**
     * 该项目有哪些环境的配置
     */
    @ManyToMany
    private List<Env> envs = new ArrayList<>();

    /**
     * 该项目的配置有哪些版本
     */
    @OneToMany(mappedBy = "project", cascade = CascadeType.REMOVE)
    private List<Label> labels = new ArrayList<>();

    public Project(Long id, String name, String confPath){
        this.id = id;
        this.name = name;
        this.confPath = confPath;
    }

}
