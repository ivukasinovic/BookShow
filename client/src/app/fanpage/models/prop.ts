export class UsedProp {
  id: number;
  title: string;
  description: string;
  dateCreated: string;
  activeUntil: string;
  status: string;
  acceptedBid: boolean;
  adminFan: number;
  registeredUser: number;
  image: string;
  user: string;
}

export class NewProp {
  id: number;
  title: string;
  description: string;
  dateCreated: string;
  price: number;
  fanAdmin: string;
  user: string;
  show: number;
  image: string;
  createdDate: string;
}

export class Bid {
  id: number;
  price: number;
  user: string;
  dateCreated: string;
}

export class AuthReq {
  token: string;
}

export class Show {
  id: number;
  name: string;
  type: string;
  address: string;
  description: string;
  rating: number;
}

export class User {
  id: number;
  username: string;
  name: string;
  surname: string;
  email: string;
  city: string;
  number: string;
  role: string;
  loggednum: number;
  type: string;
}
export class Rating {
  bronze: string;
  silver: string;
  gold: string;
}
