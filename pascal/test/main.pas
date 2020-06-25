program main;

var
    name: String;

begin
    WriteLn('Hello world!');
    Write('Your name: ');
    ReadLn(name);
    WriteLn('Hello ' + name);

    // End.
    Write('Press any key to continue...');
    ReadLn();
    WriteLn('Bye!');
end.