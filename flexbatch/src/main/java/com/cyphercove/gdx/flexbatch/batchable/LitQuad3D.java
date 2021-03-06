
package com.cyphercove.gdx.flexbatch.batchable;

import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.cyphercove.gdx.flexbatch.utils.AttributeOffsets;

/** A {@link Quad3D} with support for lighting through the use of normal, tangent, and binormal vertex attributes.
 * 
 * @author cypherdare */
public class LitQuad3D extends Quad3D {

	private static final Vector3 TMP1 = new Vector3();

	/** A LitQuad3D that starts opaque. */
	public LitQuad3D () {
	}

	/** A LitQuad3D that starts with blending enabled, with the specified blend factors. */
	public LitQuad3D (int srcBlendFactor, int dstBlendFactor) {
		super(srcBlendFactor, dstBlendFactor);
	}

	/** A LitQuad3D that starts with blending enabled, and a common set of blend factors. */
	public LitQuad3D (Blending blending) {
		super(blending);
	}

	protected void addVertexAttributes (Array<VertexAttribute> attributes) {
		super.addVertexAttributes(attributes);
		attributes.add(new VertexAttribute(Usage.Normal, 3, "a_normal"));
		attributes.add(new VertexAttribute(Usage.Tangent, 3, "a_tangent"));
		attributes.add(new VertexAttribute(Usage.BiNormal, 3, "a_binormal"));
	}

	protected int apply (float[] vertices, int vertexStartingIndex, AttributeOffsets offsets, int vertexSize) {
		super.apply(vertices, vertexStartingIndex, offsets, vertexSize);

		TMP1.set(0, 0, 1);
		rotation.transform(TMP1);
		int ni = vertexStartingIndex + offsets.normal;
		vertices[ni] = TMP1.x;
		vertices[ni + 1] = TMP1.y;
		vertices[ni + 2] = TMP1.z;
		ni += vertexSize;
		vertices[ni] = TMP1.x;
		vertices[ni + 1] = TMP1.y;
		vertices[ni + 2] = TMP1.z;
		ni += vertexSize;
		vertices[ni] = TMP1.x;
		vertices[ni + 1] = TMP1.y;
		vertices[ni + 2] = TMP1.z;
		ni += vertexSize;
		vertices[ni] = TMP1.x;
		vertices[ni + 1] = TMP1.y;
		vertices[ni + 2] = TMP1.z;

		TMP1.set(1, 0, 0);
		rotation.transform(TMP1);
		int ti = vertexStartingIndex + offsets.tangent;
		vertices[ti] = TMP1.x;
		vertices[ti + 1] = TMP1.y;
		vertices[ti + 2] = TMP1.z;
		ti += vertexSize;
		vertices[ti] = TMP1.x;
		vertices[ti + 1] = TMP1.y;
		vertices[ti + 2] = TMP1.z;
		ti += vertexSize;
		vertices[ti] = TMP1.x;
		vertices[ti + 1] = TMP1.y;
		vertices[ti + 2] = TMP1.z;
		ti += vertexSize;
		vertices[ti] = TMP1.x;
		vertices[ti + 1] = TMP1.y;
		vertices[ti + 2] = TMP1.z;

		TMP1.set(0, 1, 0);
		rotation.transform(TMP1);
		int bni = vertexStartingIndex + offsets.biNormal;
		vertices[bni] = TMP1.x;
		vertices[bni + 1] = TMP1.y;
		vertices[bni + 2] = TMP1.z;
		bni += vertexSize;
		vertices[bni] = TMP1.x;
		vertices[bni + 1] = TMP1.y;
		vertices[bni + 2] = TMP1.z;
		bni += vertexSize;
		vertices[bni] = TMP1.x;
		vertices[bni + 1] = TMP1.y;
		vertices[bni + 2] = TMP1.z;
		bni += vertexSize;
		vertices[bni] = TMP1.x;
		vertices[bni + 1] = TMP1.y;
		vertices[bni + 2] = TMP1.z;

		return 4;
	}

	// Usually, chain methods must be overridden to allow return of subclass
	// type. However, LitQuad3D does not have any unique parameter setter
	// methods, so it is acceptable to return Quad3Ds.

}
