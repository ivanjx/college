SECS_DAY = 24 * 60 * 60
SECS_HOUR = 60 * 60
SECS_MIN = 60


def main():
  # Read seconds.
  secs = int(input('Second: '))

  # Getting day.
  day = secs // SECS_DAY
  secs = secs - day * SECS_DAY

  # Getting hour.
  hour = secs // SECS_HOUR
  secs = secs - hour * SECS_HOUR

  # Getting minute.
  minute = secs // SECS_MIN
  secs = secs - minute * SECS_MIN

  # Done.
  print("Day: " + str(day))
  print("Hour: " + str(hour))
  print("Minute: " + str(minute))
  print("Second: " + str(secs))


if __name__ == "__main__":
  main()