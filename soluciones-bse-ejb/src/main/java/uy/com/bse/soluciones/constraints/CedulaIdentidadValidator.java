package uy.com.bse.soluciones.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CedulaIdentidadValidator implements ConstraintValidator<CedulaIdentidad, String> {

	@Override
	public void initialize(CedulaIdentidad constraintAnnotation) {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean isValid(String ci, ConstraintValidatorContext context) {
		Boolean valida = Boolean.TRUE;

		if (ci == null || !ci.matches("[0-9]*-[0-9]")) {
			valida = Boolean.FALSE;
		} else {
			// Digito verificador
			String aux = ci.substring(0, ci.length() - 2);
			int digitoAux = Integer.valueOf(ci.substring(ci.length() - 1));
			int digitoVerificador = getDigitoVerificador(aux);
			if (digitoAux != digitoVerificador) {
				valida = Boolean.FALSE;
			}
			// Mayor a siete millones, seguramente no sea valida
			if (Integer.valueOf(aux) > 7000000) {
				valida = Boolean.FALSE;
			}
		}
		return valida;
	}

	// Calcula el digito verificador para una cedula
	private int getDigitoVerificador(String documento) throws NumberFormatException {
		documento = documento.trim();

		String base = "45632732987634";
		String auxBase, auxDoc;
		int aux1, aux2;
		base = base.substring(base.length() - documento.length());
		int suma = 0;

		for (int i = 0; i < documento.length(); i++) {
			auxBase = base;
			auxDoc = documento;
			aux1 = Integer.valueOf(auxBase.substring(i, i + 1)).intValue();
			aux2 = Integer.valueOf(auxDoc.substring(i, i + 1)).intValue();
			suma += aux1 * aux2;
		}

		int dc = suma % 10;
		if (dc > 0) {
			dc = 10 - dc;
		}
		return dc;
	}
}