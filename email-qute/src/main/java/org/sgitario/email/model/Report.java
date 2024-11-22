package org.sgitario.email.model;

import java.io.File;

public record Report(boolean hasData, File attachedFile) {
}
