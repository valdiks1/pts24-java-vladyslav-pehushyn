package sk.uniba.fmph.dcs;

import java.util.Collection;
import java.util.OptionalInt;

interface Building {
  OptionalInt build(Collection<Effect> resources);
}
