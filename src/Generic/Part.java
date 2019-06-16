package Generic;


import java.util.ArrayList;
import java.util.List;

public class Part {
    static List<Factory<? extends Part>> list = new ArrayList<>();
    static {
        list.add(new FanBelt.Factory());
        list.add(new AirFilter.Factory());
        list.add(new FuleFilter.Factory());
        list.add(new GeneratorBelt.Factory());
    }
}
class Filter extends Part{
}
class FuleFilter extends Filter{
    public static class Factory implements Generic.Factory<FuleFilter>{

        @Override
        public FuleFilter create() {
            return new FuleFilter();
        }
    }
}
class AirFilter extends Filter {
    public static class Factory implements Generic.Factory<AirFilter> {
        public AirFilter create() {
            return new AirFilter();
        }
    }
}
class Belt extends Part {}
class FanBelt extends Belt {
    public static class Factory implements Generic.Factory<FanBelt> {
        public FanBelt create() {
            return new FanBelt();
        }
    }
}
class GeneratorBelt extends Belt {
    public static class Factory implements Generic.Factory<GeneratorBelt> {
        public GeneratorBelt create() {
            return new GeneratorBelt();
        }
    }
}

