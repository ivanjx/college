program main;

procedure greetings;
var
    name: String;
begin
    WriteLn('Hello world!');
    Write('Your name: ');
    ReadLn(name);
    WriteLn('Hello ' + name);
end;

function add(num1: Integer; num2: Integer):Real;
begin
    add := num1 + num2;
end;

function sub(num1: Integer; num2: Integer):Real;
begin
    sub := num1 - num2;
end;

function divide(num1: Integer; num2: Integer):Real;
begin
    divide := num1 / num2;
end;

function mul(num1: Integer; num2: Integer):Real;
begin
    mul := num1 * num2;
end;

var
    num1: Integer;
    num2: Integer;
    res: Real;
    op: Char;

begin
    greetings();

    Write('Enter number1: ');
    ReadLn(num1);
    Write('Enter number2: ');
    ReadLn(num2);
    Write('Operator (+-*/): ');
    ReadLn(op);

    if op = '+' then
    begin
        res := add(num1, num2);
    end
    else if op = '-' then
    begin
        res := sub(num1, num2);
    end
    else if op = '*' then
    begin
        res := mul(num1, num2);
    end
    else
    begin
        res := divide(num1, num2);
    end;

    Write('Result: ');
    WriteLn(res);

    // End.
    Write('Press enter to exit...');
    ReadLn();
    WriteLn('Bye!');
end.