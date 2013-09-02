package playn.core.gl;

import static playn.core.gl.GL20.*;

/**
 * User: ylevin
 * Date: 02.09.13
 */
public interface GL20BlendMode extends BlendMode {

  void apply(GL20 gl);

  GL20BlendMode MASK = new SimpleBlendMode(GL_ZERO, GL_SRC_ALPHA);
  GL20BlendMode INVERTED_MASK = new SimpleBlendMode(GL_ZERO, GL_ONE_MINUS_SRC_ALPHA);
  GL20BlendMode NORMAL = new SimpleBlendMode(GL_ONE, GL_ONE_MINUS_SRC_ALPHA);

  class SimpleBlendMode implements GL20BlendMode {
    private int sFactor;
    private int dFactor;

    public SimpleBlendMode(int sFactor, int dFactor) {
      this.sFactor = sFactor;
      this.dFactor = dFactor;
    }

    @Override
    public void apply(GL20 gl) {
      gl.glBlendFunc(sFactor, dFactor);
    }
  }

  class SeparateBlendMode implements GL20BlendMode {
    private int sFactorRbg;
    private int sFactorAlpha;
    private int dFactorRbg;
    private int dFactorAlpha;

    public SeparateBlendMode(int sFactorRbg, int sFactorAlpha, int dFactorRbg, int dFactorAlpha) {
      this.sFactorRbg = sFactorRbg;
      this.sFactorAlpha = sFactorAlpha;
      this.dFactorRbg = dFactorRbg;
      this.dFactorAlpha = dFactorAlpha;
    }

    @Override
    public void apply(GL20 gl) {
      gl.glBlendFuncSeparate(sFactorRbg, dFactorRbg, sFactorAlpha, dFactorAlpha);
    }
  }

}
