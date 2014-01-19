/**
 * Copyright 2013 The PlayN Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package playn.core;

/**
 * Contains the configuration needed when wrapping text.
 */
public class TextWrap {

  /** An instance that indicates that we should only wrap on manual line breaks and not at any
   * specific width. */
  public static final TextWrap MANUAL = new TextWrap(Float.MAX_VALUE);

  /** The width at which the text is wrapped. */
  public final float width;

  /** An indent applied to the first line of text. */
  public final float indent;

  /** Creates a text wrap config with the specified width and no indent. */
  public TextWrap(float width) {
    this(width, 0);
  }

  /** Creates a text wrap config with the specified width and indent. */
  public TextWrap(float width, float indent) {
    this.width = width;
    this.indent = indent;
  }

  @Override public int hashCode() {
    return (int)width ^ (int)indent;
  }

  @Override public boolean equals(Object other) {
    if (other instanceof TextWrap) {
      TextWrap ow = (TextWrap)other;
      return width == ow.width && indent == ow.indent;
    } else {
      return false;
    }
  }
}
