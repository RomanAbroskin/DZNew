package org.top.dznew.Records;

public class Records {

 public interface Message {}
 public record StringMessage (String Message) implements Message{}
 public record ErrorMessage (String Message) implements Message{}
 public record InputDataMessage (Double killometr,Double metor,Double mille) implements Message{}
 public record OutputDataMessage (Double MetorKillometr,Double KillometrMetor,Double MilleKillometr) implements Message{}
}
