package com.homework.crudimpl.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Author {
  private int id;
  private String name;
  private String nationality;
}