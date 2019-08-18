devs(Devs) :-
  Devs = [Jessie, Evan, John, Sarah, Matt],

  fd_domain(Devs, 1, 5),

  fd_all_different(Devs),

  fd_labeling(Devs),

  Jessie =\= 1,
  Evan =\= 5,
  John =\= 1,
  John =\= 5,
  Sarah < Evan,
  abs(Matt - John) =\= 1,
  abs(John - Evan) =\= 1.

