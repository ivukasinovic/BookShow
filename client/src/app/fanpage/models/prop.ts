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
  createdDate: string;
}

export class NewProp {
  id: number;
  title: string;
  description: string;
  dateCreated: string;
  price: number;
  adminFan: number;
  registeredUser: number;
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
  ShowType: string;
  adress: string;
  rating: number;
}
