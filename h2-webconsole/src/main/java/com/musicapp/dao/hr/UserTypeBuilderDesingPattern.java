package com.musicapp.dao.hr;

/**
 * UserTypeBuilderDesingPattern
 */
public class UserTypeBuilderDesingPattern {
  private long user_type_id;
  private String user_type;
  private String user_type_desc;

  private UserTypeBuilderDesingPattern(long user_type_id, String user_type, String user_type_desc) {
    this.user_type_id = user_type_id;
    this.user_type = user_type;
    this.user_type_desc = user_type_desc;
  }

  /**
   * Builder class
   */
  public static class UserTypeBuilderDesingPatternBuilder {
    private long user_type_id;
    private String user_type;
    private String user_type_desc;

    public UserTypeBuilderDesingPatternBuilder setUser_type_id(long user_type_id) {
      this.user_type_id = user_type_id;
      return this;
    }

    public UserTypeBuilderDesingPatternBuilder setUser_type(String user_type) {
      this.user_type = user_type;
      return this;
    }

    public UserTypeBuilderDesingPatternBuilder setUser_type_desc(String user_type_desc) {
      this.user_type_desc = user_type_desc;
      return this;
    }

    public UserTypeBuilderDesingPattern createUserTypeBuilderDesingPattern() {
      return new UserTypeBuilderDesingPattern(user_type_id, user_type, user_type_desc);
    }
  }
}
